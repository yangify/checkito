package io.hongyang.checkito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CheckitoServiceTests {

  @Mock CheckitoRepository checkitoRepository;

  @InjectMocks CheckitoService checkitoService;

  @Test
  void getAllToDos() {
    // Given
    Checkito expctedCheckito = Checkito.builder().text("Checkito 1").isCompleted(false).build();
    List<Checkito> expectedCheckitos = List.of(expctedCheckito);

    // When
    when(checkitoRepository.findAll()).thenReturn(expectedCheckitos);
    List<Checkito> checkitos = checkitoService.findAll();
    Checkito actualCheckito = checkitos.get(0);

    // Then
    assertEquals(expctedCheckito, actualCheckito);
  }
}
