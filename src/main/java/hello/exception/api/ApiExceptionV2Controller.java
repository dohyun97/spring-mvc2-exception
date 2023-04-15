package hello.exception.api;

import hello.exception.exception.UserExcepeiton;
import hello.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApiExceptionV2Controller {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illeaglExhandle(IllegalArgumentException e){
        log.error("[exceptionHandel] ex" ,e);
        return new ErrorResult("BAD",e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandle(UserExcepeiton e){
        log.error("[exception handle]" ,e);
        ErrorResult errorResult = new ErrorResult("USER-ex",e.getMessage());
        return new ResponseEntity<>(errorResult,HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandle(Exception e){
        log.error("[exceptionHandel] ex" ,e);
        return new ErrorResult("EX","INTERNAL ERROR");
    }


    @GetMapping("/api2/members/{id}")
    public ApiExceptionController.MemberDto getMember(@PathVariable String id){
        if(id.equals("ex")){
            throw new RuntimeException("잘못된 사용자");
        }
        if(id.equals("bad")){
            throw new IllegalArgumentException("잘못된 입력 값");
        }
        if(id.equals("user-ex")){
            throw new UserExcepeiton("사용자 오류");
        }
        return new ApiExceptionController.MemberDto(id,"hello"+id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String memberId;
        private String name;
    }
}
