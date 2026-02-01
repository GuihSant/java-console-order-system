package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import enums.StatusPedido;

public class Pedido {

    private UUID id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private LocalDateTime dataHora;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.ABERTO;
        this.dataHora = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public List<ItemPedido> getItens() {
        return itens;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }
    public void pagar() {
        if (this.status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Pedido não pode ser pago. Status atual: " + this.status);
        }
        this.status = StatusPedido.PAGO;
    }
    public void cancelar() {
        if (this.status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Pedido não pode ser cancelado. Status atual: " + this.status);
        }
        this.status = StatusPedido.CANCELADO;
    }


    public String calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return String.format("R$ %.2f", total);
    }
}
