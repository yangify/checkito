package io.hongyang.checkito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CheckitoRepositoryTests {

  @Autowired CheckitoRepository checkitoRepository;

  @Test
  public void testCreateReadDelete() {
    // Given
    Checkito expctedCheckito = Checkito.builder().text("Checkito 1").isCompleted(false).build();

    // When
    checkitoRepository.save(expctedCheckito);

    // Then
    List<Checkito> checkitos = checkitoRepository.findAll();
    Checkito actualCheckito = checkitos.get(0);
    assertEquals(expctedCheckito, actualCheckito);
  }

  @AfterEach
  void teardown() {
    checkitoRepository.deleteAll();
    assertThat(checkitoRepository.findAll()).isEmpty();
  }
}
