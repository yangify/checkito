package io.hongyang.checkito;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckitoController {

  private CheckitoService checkitoService;

  @GetMapping("/todos")
  ResponseEntity<List<Checkito>> getAllToDos() {
    return new ResponseEntity<>(checkitoService.findAll(), HttpStatus.OK);
  }
}
