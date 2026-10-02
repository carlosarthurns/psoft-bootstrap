import java.time.LocalDate;

public class Sprint {

    private Funcionario lider;
    private LocalDate inicio;
    private LocalDate fim;
    private String id;

    public Sprint(Funcionario lider, LocalDate inicio, String id) {
        this.lider = lider;
        this.inicio = inicio;
        this.id = id;
    }

    public void finalizar(LocalDate fim) {
        this.fim = fim;
    }

    public Funcionario getLider() {
        return lider;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public String getId() {
        return id;
    }
    
}