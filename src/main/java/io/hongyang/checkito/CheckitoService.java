package io.hongyang.checkito;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckitoService {

  private CheckitoRepository checkitoRepository;

  public List<Checkito> findAll() {
    return checkitoRepository.findAll();
  }
}
