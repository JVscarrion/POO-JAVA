import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // ARRAYLIST para armazenar os cursos
    private static ArrayList<Curso> listaCursos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch(opcao) {
                case 1:
                    cadastrarCursoPresencial();
                    break;
                case 2:
                    cadastrarCursoOnline();
                    break;
                case 3:
                    cadastrarCursoHibrido();
                    break;
                case 4:
                    listarTodosCursos();
                    break;
                case 5:
                    buscarCursoPorCodigo();
                    break;
                case 6:
                    calcularCustoTotalCursos();
                    break;
                case 7:
                    listarCursosPorTipo();
                    break;
                case 8:
                    removerCurso();
                    break;
                case 9:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 9);
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE GESTÃO DE CURSOS ===");
        System.out.println("1. Cadastrar Curso Presencial");
        System.out.println("2. Cadastrar Curso Online");
        System.out.println("3. Cadastrar Curso Híbrido");
        System.out.println("4. Listar Todos os Cursos");
        System.out.println("5. Buscar Curso por Código");
        System.out.println("6. Calcular Custo Total de Todos os Cursos");
        System.out.println("7. Listar Cursos por Tipo");
        System.out.println("8. Remover Curso");
        System.out.println("9. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarCursoPresencial() {
        System.out.println("\n=== CADASTRAR CURSO PRESENCIAL ===");

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nome do Instrutor: ");
        String instrutor = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        System.out.print("Valor Base: ");
        double valorBase = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Sala: ");
        String sala = scanner.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();

        CursoPresencial curso = new CursoPresencial(codigo, titulo, instrutor, cargaHoraria,
                valorBase, sala, capacidade);
        listaCursos.add(curso); // ARRAYLIST - Adiciona à lista
        System.out.println("\nCurso presencial cadastrado com sucesso!");
        curso.mostrarInformacoes(); // Exibe informações do curso cadastrado
    }

    private static void cadastrarCursoOnline() {
        System.out.println("\n=== CADASTRAR CURSO ONLINE ===");

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nome do Instrutor: ");
        String instrutor = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        System.out.print("Valor Base: ");
        double valorBase = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Plataforma: ");
        String plataforma = scanner.nextLine();
        System.out.print("Tempo de Duração (dias): ");
        int tempoDuracao = scanner.nextInt();

        CursoOnline curso = new CursoOnline(codigo, titulo, instrutor, cargaHoraria,
                valorBase, plataforma, tempoDuracao);
        listaCursos.add(curso); // ARRAYLIST - Adiciona à lista
        System.out.println("\nCurso online cadastrado com sucesso!");
        curso.mostrarInformacoes(); // Exibe informações do curso cadastrado
    }

    private static void cadastrarCursoHibrido() {
        System.out.println("\n=== CADASTRAR CURSO HÍBRIDO ===");

        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nome do Instrutor: ");
        String instrutor = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        System.out.print("Valor Base: ");
        double valorBase = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Dias da Semana: ");
        String diasSemana = scanner.nextLine();
        System.out.print("Número de Aulas: ");
        int nrAulas = scanner.nextInt();

        CursoHibrido curso = new CursoHibrido(codigo, titulo, instrutor, cargaHoraria,
                valorBase, diasSemana, nrAulas);
        listaCursos.add(curso); // ARRAYLIST - Adiciona à lista
        System.out.println("\nCurso híbrido cadastrado com sucesso!");
        curso.mostrarInformacoes(); // Exibe informações do curso cadastrado
    }

    private static void listarTodosCursos() {
        System.out.println("\n=== LISTA DE TODOS OS CURSOS ===");
        if(listaCursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        // POLIMORFISMO em ação - mesmo método, comportamentos diferentes
        for(int i = 0; i < listaCursos.size(); i++) {
            System.out.println("\n--- Curso " + (i+1) + " ---");
            listaCursos.get(i).mostrarInformacoes(); // Cada classe executa sua versão
            System.out.println("----------------------------------------");
        }
    }

    private static void buscarCursoPorCodigo() {
        System.out.print("\nDigite o código do curso: ");
        int codigo = scanner.nextInt();

        boolean encontrado = false;
        for(Curso curso : listaCursos) { // Enhanced for loop
            if(curso.getCodigo() == codigo) {
                System.out.println("\n=== CURSO ENCONTRADO ===");
                curso.mostrarInformacoes();
                encontrado = true;
                break;
            }
        }

        if(!encontrado) {
            System.out.println("Curso com código " + codigo + " não encontrado!");
        }
    }

    private static void calcularCustoTotalCursos() {
        if(listaCursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        double custoTotal = 0;
        System.out.println("\n=== RELATÓRIO DE CUSTOS ===");

        for(Curso curso : listaCursos) {
            double custoCurso = curso.calcularCustosCursos();
            custoTotal += custoCurso;
            System.out.println("Código " + curso.getCodigo() + " - " + curso.getTitulo() +
                    ": R$ " + String.format("%.2f", custoCurso));
        }

        System.out.println("----------------------------------------");
        System.out.println("CUSTO TOTAL DE TODOS OS CURSOS: R$ " + String.format("%.2f", custoTotal));
    }

    private static void listarCursosPorTipo() {
        System.out.println("\n1. Cursos Presenciais");
        System.out.println("2. Cursos Online");
        System.out.println("3. Cursos Híbridos");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();

        System.out.println("\n=== CURSOS FILTRADOS ===");
        boolean encontrou = false;

        for(Curso curso : listaCursos) {
            // INSTANCEOF - verifica o tipo da classe
            if(tipo == 1 && curso instanceof CursoPresencial) {
                curso.mostrarInformacoes();
                System.out.println("---");
                encontrou = true;
            } else if(tipo == 2 && curso instanceof CursoOnline) {
                curso.mostrarInformacoes();
                System.out.println("---");
                encontrou = true;
            } else if(tipo == 3 && curso instanceof CursoHibrido) {
                curso.mostrarInformacoes();
                System.out.println("---");
                encontrou = true;
            }
        }

        if(!encontrou) {
            System.out.println("Nenhum curso encontrado para esse tipo!");
        }
    }

    private static void removerCurso() {
        if(listaCursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        System.out.println("\n=== REMOVER CURSO ===");
        for(int i = 0; i < listaCursos.size(); i++) {
            System.out.println(i + ". Código: " + listaCursos.get(i).getCodigo() +
                    " - " + listaCursos.get(i).getTitulo());
        }

        System.out.print("Digite o índice do curso a remover: ");
        int indice = scanner.nextInt();

        if(indice >= 0 && indice < listaCursos.size()) {
            Curso removido = listaCursos.remove(indice); // ARRAYLIST - Remove da lista
            System.out.println("Curso '" + removido.getTitulo() + "' removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
}