package com.barberia.sistema.service;

import com.barberia.sistema.domain.Cliente;
import com.barberia.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void guardar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente obtenerPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
