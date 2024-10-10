package com.mendoza.facturacion.almacen.config;

import com.mendoza.facturacion.almacen.exception.GeneralException;
import com.mendoza.facturacion.almacen.exception.NoDataFoundException;
import com.mendoza.facturacion.almacen.exception.ValidateException;
import com.mendoza.facturacion.almacen.util.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> all(Exception e, WebRequest request) {
        WrapperResponse<?> response = new WrapperResponse<>(false, "Internal server error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<?> validation(ValidateException e, WebRequest request) {
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<?> noData(NoDataFoundException e, WebRequest request) {
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<?> noData(GeneralException e, WebRequest request) {
        WrapperResponse<?> response = new WrapperResponse<>(false, "Internal server error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
