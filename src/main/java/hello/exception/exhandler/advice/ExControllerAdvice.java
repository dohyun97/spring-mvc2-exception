package hello.exception.exhandler.advice;

import hello.exception.exception.UserExcepeiton;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice("hello.exception.api") //특정 패키지 또는 하위에만 이 오류처리가 적용되도록
public class ExControllerAdvice {
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

}
