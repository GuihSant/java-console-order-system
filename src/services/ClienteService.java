package services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import entities.Cliente;

public class ClienteService {

    private final Map<UUID, Cliente> clientes = new HashMap<>();

    public Cliente criar(String nome, String email) {
        Cliente c = new Cliente(nome, email);
        clientes.put(c.getId(), c);
        return c;
    }

    public Cliente buscar(UUID id) {
        return clientes.get(id);
    }

    public boolean existe(UUID id) {
        return clientes.containsKey(id);
    }
}
