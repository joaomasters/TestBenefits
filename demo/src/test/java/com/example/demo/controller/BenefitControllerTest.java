package com.example.demo.controller;


import com.example.demo.controller.BenefitController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seuusuario.beneficiosapi.domain.model.Benefit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(BenefitController.class)
public class BenefitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private com.beneficiosapi.controller.service.BenefitService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarBeneficio() throws Exception {
        Benefit b = new Benefit(null, "Vale Alimentação", "Benefício mensal", true);
        when(service.criar(any())).thenReturn(b);

        mockMvc.perform(post("/benefits")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(b)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Vale Alimentação"));
    }
}
