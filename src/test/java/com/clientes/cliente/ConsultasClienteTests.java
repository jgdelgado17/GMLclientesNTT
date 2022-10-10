package com.clientes.cliente;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodName.class)
public class ConsultasClienteTests {
    public static final Integer DOCUMENTO = 7;
    public static final String TIPODOCUMENTO = "P";
    public static final String PRIMERNOMBRE = "Jesus";
    public static final String SEGUNDONOMBRE = "Gabriel";
    public static final String PRIMERAPELLIDO = "Delgado";
    public static final String SEGUNDOAPELLIDO = "Leal";
    public static final String TELEFONO = "3102203726";
    public static final String DIRECCION = "Cll 1";
    public static final String CIUDAD = "Pamplona";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void t1_InsertarClienteDeberiaRecibir201() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper
                                .writeValueAsString(new ClienteTest(1, DOCUMENTO, TIPODOCUMENTO, PRIMERNOMBRE,
                                        SEGUNDONOMBRE, PRIMERAPELLIDO, PRIMERAPELLIDO, TELEFONO, DIRECCION, CIUDAD))))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void t2_ConsultarCorrectoDeberiaRecibir200() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/cliente/cd/" + DOCUMENTO + ",P")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void t3_ConsultarDocumentoIncorrectoDeberiaRecibir500() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/cliente/cd/" + 6 + ",P")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void t4_ConsultarTipoDocIncorrectoDeberiaRecibir400() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/cliente/cd/" + DOCUMENTO + ",TI")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void t5_ConsultarIdIncorrectoDeberiaRecibir404() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/cliente/id/" + DOCUMENTO)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void t6_EliminarClienteDeberiaRecibir200() throws Exception {
        MvcResult cliente = mvc.perform(
                MockMvcRequestBuilders.get("/cliente/cds/" + DOCUMENTO)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        ClienteTest resultadoCliente = objectMapper.readValue(cliente.getResponse().getContentAsString(),
                ClienteTest.class);

        mvc.perform(
                MockMvcRequestBuilders.delete("/cliente/" + resultadoCliente.getClie_id())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
