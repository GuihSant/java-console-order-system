package services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;

public class PedidoService {

    private final Map<UUID, Pedido> pedidos = new HashMap<>();

    public Pedido criar(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidos.put(pedido.getId(), pedido);
        return pedido;
    }

    public Pedido buscar(UUID id) {
        return pedidos.get(id);
    }

    public void adicionarItem(Pedido pedido, Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        pedido.adicionarItem(item);
    }

    public void pagar(Pedido pedido) {
        pedido.pagar();
    }

    public void cancelar(Pedido pedido) {
        pedido.cancelar();
    }
}
