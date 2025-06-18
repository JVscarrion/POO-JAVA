public class CursoHibrido extends Curso {
    private String diasSemana;
    private int nrAulas;

    public CursoHibrido(int codigo, String titulo, String nomeInstrutor, int cargaHoraria,
                        double valorBase, String diasSemana, int nrAulas) {
        super(codigo, titulo, nomeInstrutor, cargaHoraria, valorBase);
        this.diasSemana = diasSemana;
        this.nrAulas = nrAulas;
    }

    // POLIMORFISMO - Sobrescreve o método da classe pai
    @Override
    public void cadastrarInformacoes() {
        super.cadastrarInformacoes();
        System.out.println("Dias da Semana: " + diasSemana);
        System.out.println("Número de Aulas: " + nrAulas);
        System.out.println("Modalidade: Híbrido");
    }

    // POLIMORFISMO - Calcula custo com 15% sobre valor base
    @Override
    public double calcularCustosCursos() {
        return valorBase + (valorBase * 0.15); // 15% sobre o valor base
    }

    // POLIMORFISMO - Mostra informações específicas
    @Override
    public void mostrarInformacoes() {
        cadastrarInformacoes();
        System.out.println("Acréscimo: 15% sobre valor base");
        System.out.println("Custo Total: R$ " + String.format("%.2f", calcularCustosCursos()));
    }

    public String getDiasSemana() { return diasSemana; }
    public int getNrAulas() { return nrAulas; }
}