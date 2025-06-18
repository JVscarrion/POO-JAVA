public class Curso {
    protected int codigo;
    protected String titulo;
    protected String nomeInstrutor;
    protected int cargaHoraria;
    protected double valorBase;

    public Curso(int codigo, String titulo, String nomeInstrutor, int cargaHoraria, double valorBase) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.nomeInstrutor = nomeInstrutor;
        this.cargaHoraria = cargaHoraria;
        this.valorBase = valorBase;
    }

    // Método que será sobrescrito pelas classes filhas (POLIMORFISMO)
    public void cadastrarInformacoes() {
        System.out.println("=== INFORMAÇÕES BÁSICAS DO CURSO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Instrutor: " + nomeInstrutor);
        System.out.println("Carga Horária: " + cargaHoraria + "h");
        System.out.println("Valor Base: R$ " + valorBase);
    }

    // Método que será sobrescrito pelas classes filhas (POLIMORFISMO)
    public double calcularCustosCursos() {
        return valorBase; // Apenas valor base sem acréscimo
    }

    // Método que será sobrescrito pelas classes filhas (POLIMORFISMO)
    public void mostrarInformacoes() {
        cadastrarInformacoes();
        System.out.println("Custo Total: R$ " + calcularCustosCursos());
    }

    // Getters
    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getNomeInstrutor() { return nomeInstrutor; }
    public int getCargaHoraria() { return cargaHoraria; }
    public double getValorBase() { return valorBase; }
}

