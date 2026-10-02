import java.time.LocalDate;
import java.util.List;

public class Time {

    private List<Funcionario> desenvolvedores;
    private Produto produto;
    private Funcionario gerente;
    private List<Sprint> sprints;
    private String id;

    public Time(Funcionario gerente, Produto produto, String id) {
        this.produto = produto;
        this.gerente = gerente;
        this.id = id;
    }

    public void addDesenvolvedor(Funcionario desenvolvedor) {
        this.desenvolvedores.add(desenvolvedor);
    }

    public void removeDesenvolvedor(Funcionario desenvolvedor) {
        this.desenvolvedores.remove(desenvolvedor);
    }

    public void mudarGerente(Funcionario newGerente) {
        this.gerente = newGerente;
    }

    public void addSprint(Funcionario lider, LocalDate inicio) {
        String id = formataIdSprint();
        this.sprints.add(new Sprint(lider, inicio, id));
    }

    public void finalizaSprint(LocalDate fim, String idSprint) {
        for (Sprint sprint : this.sprints)
            if (sprint.getId().equals(idSprint))
                sprint.finalizar(fim);
    }
    
    public List<Funcionario> getDesenvolvedores() {
        return desenvolvedores;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public Funcionario getGerente() {
        return gerente;
    }
    
    public List<Sprint> getSprints() {
        return sprints;
    }

    public String getId() {
        return id;
    }

    private String formataIdSprint() {
        return "Sprint" + (this.sprints.size() + 1);
    }   

}