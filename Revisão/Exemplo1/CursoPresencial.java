public class CursoPresencial extends Curso {
    private String sala;
    private int capacidade;

    public CursoPresencial(int codigo, String titulo, String nomeInstrutor, int cargaHoraria,
                           double valorBase, String sala, int capacidade) {
        super(codigo, titulo, nomeInstrutor, cargaHoraria, valorBase); // Chama construtor da classe pai
        this.sala = sala;
        this.capacidade = capacidade;
    }

    // POLIMORFISMO - Sobrescreve o método da classe pai
    @Override
    public void cadastrarInformacoes() {
        super.cadastrarInformacoes(); // Chama método da classe pai
        System.out.println("Sala: " + sala);
        System.out.println("Capacidade: " + capacidade + " alunos");
        System.out.println("Modalidade: Presencial");
    }

    // POLIMORFISMO - Calcula custo com 25% sobre valor base
    @Override
    public double calcularCustosCursos() {
        return valorBase + (valorBase * 0.25); // 25% sobre o valor base
    }

    // POLIMORFISMO - Mostra informações específicas
    @Override
    public void mostrarInformacoes() {
        cadastrarInformacoes();
        System.out.println("Acréscimo: 25% sobre valor base");
        System.out.println("Custo Total: R$ " + String.format("%.2f", calcularCustosCursos()));
    }

    public String getSala() { return sala; }
    public int getCapacidade() { return capacidade; }
}