package io.hongyang.checkito;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CheckitoControllerTests {

  @Autowired MockMvc mockMvc;

  @MockBean private CheckitoService checkitoService;

  @Test
  void getAllToDos() throws Exception {
    List<Checkito> checkitoList = new ArrayList<>();
    checkitoList.add(new Checkito(1L, "Eat thrice", true));
    checkitoList.add(new Checkito(2L, "Sleep Twice", true));
    when(checkitoService.findAll()).thenReturn(checkitoList);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/todos").contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andDo(print());
  }
}
