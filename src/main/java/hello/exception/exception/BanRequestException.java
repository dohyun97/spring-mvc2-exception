package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//이 예외가 터지면 어노테이션을 확인해서 상태코드를 변경하고 메세지를 담아
//@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "잘못된 요청 오류")
@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "error.bad") //use messages.properties
public class BanRequestException extends RuntimeException{
}
