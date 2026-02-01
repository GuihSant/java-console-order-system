package application;

import java.util.Scanner;
import java.util.UUID;

import entities.Cliente;
import entities.Pedido;
import entities.Produto;
import enums.CategoriaProduto;
import services.ClienteService;
import services.PedidoService;
import services.ProdutoService;
import utils.ConsoleInput;

public class ConsoleApp {

    private final Scanner sc = new Scanner(System.in);
    private final ConsoleInput input = new ConsoleInput(sc);

    private final ClienteService clienteService = new ClienteService();
    private final ProdutoService produtoService = new ProdutoService();
    private final PedidoService pedidoService = new PedidoService();

    public void run() {
        int opcao;
        do {
            mostrarMenu();
            opcao = input.lerInt("Escolha uma opção: ");

            try {
                switch (opcao) {
                    case 1 -> criarCliente();
                    case 2 -> criarProduto();
                    case 3 -> criarPedido();
                    case 4 -> adicionarItem();
                    case 5 -> pagarPedido();
                    case 6 -> cancelarPedido();
                    case 7 -> exibirPedido();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }

    private void mostrarMenu() {
        System.out.println("\n1 - Criar Cliente");
        System.out.println("2 - Criar Produto");
        System.out.println("3 - Criar Pedido");
        System.out.println("4 - Adicionar Item ao Pedido");
        System.out.println("5 - Pagar Pedido");
        System.out.println("6 - Cancelar Pedido");
        System.out.println("7 - Exibir Pedido");
        System.out.println("0 - Sair");
    }

    private void criarCliente() {
        String nome = input.lerLinha("Nome do Cliente: ");
        String email = input.lerLinha("Email do Cliente: ");

        Cliente c = clienteService.criar(nome, email);
        System.out.println("Cliente criado com ID: " + c.getId());
    }

    private void criarProduto() {
        String nome = input.lerLinha("Nome do Produto: ");
        double preco = input.lerDouble("Preço do Produto: ");
        CategoriaProduto categoria = escolherCategoria();

        Produto p = produtoService.criar(nome, preco, categoria);
        System.out.println("Produto criado com ID: " + p.getId());
    }

    private void criarPedido() {
        UUID clienteId = input.lerUUID("ID do Cliente para o Pedido: ");
        Cliente cliente = clienteService.buscar(clienteId);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Pedido pedido = pedidoService.criar(cliente);
        System.out.println("Pedido criado com ID: " + pedido.getId());
    }

    private void adicionarItem() {
        UUID pedidoId = input.lerUUID("ID do Pedido: ");
        Pedido pedido = pedidoService.buscar(pedidoId);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        UUID produtoId = input.lerUUID("ID do Produto: ");
        Produto produto = produtoService.buscar(produtoId);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        int quantidade = input.lerInt("Quantidade: ");
        pedidoService.adicionarItem(pedido, produto, quantidade);

        System.out.println("Item adicionado com sucesso.");
    }

    private void pagarPedido() {
        UUID pedidoId = input.lerUUID("ID do Pedido para Pagar: ");
        Pedido pedido = pedidoService.buscar(pedidoId);

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        pedidoService.pagar(pedido);
        System.out.println("Pedido pago com sucesso.");
    }

    private void cancelarPedido() {
        UUID pedidoId = input.lerUUID("ID do Pedido para Cancelar: ");
        Pedido pedido = pedidoService.buscar(pedidoId);

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        pedidoService.cancelar(pedido);
        System.out.println("Pedido cancelado.");
    }

    private void exibirPedido() {
        UUID pedidoId = input.lerUUID("ID do Pedido para Exibir: ");
        Pedido pedido = pedidoService.buscar(pedidoId);

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("Total: " + pedido.calcularTotal());
        System.out.println("Data/hora: " + pedido.getDataHora());
    }

    private CategoriaProduto escolherCategoria() {
        CategoriaProduto[] valores = CategoriaProduto.values();

        System.out.println("Categorias:");
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i + 1) + " - " + valores[i]);
        }

        while (true) {
            int op = input.lerInt("Escolha a categoria: ");
            if (op >= 1 && op <= valores.length) return valores[op - 1];
            System.out.println("Opção inválida.");
        }
    }
}
