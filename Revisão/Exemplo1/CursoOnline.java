public class CursoOnline extends Curso {
    private String plataforma;
    private int tempoDuracao; // em dias

    public CursoOnline(int codigo, String titulo, String nomeInstrutor, int cargaHoraria,
                       double valorBase, String plataforma, int tempoDuracao) {
        super(codigo, titulo, nomeInstrutor, cargaHoraria, valorBase);
        this.plataforma = plataforma;
        this.tempoDuracao = tempoDuracao;
    }

    // POLIMORFISMO - Sobrescreve o método da classe pai
    @Override
    public void cadastrarInformacoes() {
        super.cadastrarInformacoes();
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Tempo de Duração: " + tempoDuracao + " dias");
        System.out.println("Modalidade: Online");
    }

    // POLIMORFISMO - Calcula custo com 10% sobre valor base
    @Override
    public double calcularCustosCursos() {
        return valorBase + (valorBase * 0.10); // 10% sobre o valor base
    }

    // POLIMORFISMO - Mostra informações específicas
    @Override
    public void mostrarInformacoes() {
        cadastrarInformacoes();
        System.out.println("Acréscimo: 10% sobre valor base");
        System.out.println("Custo Total: R$ " + String.format("%.2f", calcularCustosCursos()));
    }

    public String getPlataforma() { return plataforma; }
    public int getTempoDuracao() { return tempoDuracao; }
}