import java.time.LocalDate;
import java.util.*;

public class Empresa {
    private Funcionario productOwner;
    private String cnpj;
    private List<Funcionario> funcionarios;
    private List<Time> times;
    private List<Produto> produtos;

    public Empresa(String cnpj, Funcionario productOwner) {
        this.productOwner = productOwner;
        this.cnpj = cnpj;
        this.funcionarios = new ArrayList<>();
        this.times = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public void addFuncionario(String nome, String cpf, String funcao) {
        Funcionario newFuncionario = new Funcionario(nome, cpf, funcao);

        if ("ProductOwner".equals(funcao))
            productOwner = newFuncionario;

        funcionarios.add(newFuncionario);
    }

    public void removeFuncionario(String cpfFuncionario) {
        Funcionario func = buscarFuncionario(cpfFuncionario);
        funcionarios.remove(func);
    }

    public void promoverFuncionarioAGerente(String cpfFuncionario, String idTime) {
        Funcionario funcionario = buscarFuncionario(cpfFuncionario);
        Time time = buscarTime(idTime);

        funcionario.promoverAGerente();
        time.mudarGerente(funcionario);
    }

    public void promoverFuncionarioAPO(String cpfFuncionario) {
        Funcionario func = buscarFuncionario(cpfFuncionario);
        func.promoverAProductOwner();
        this.productOwner = func;
    }

    public void addProduto(String id, String nome) {
        produtos.add(new Produto(id, nome));
    }

    public void addTime(Funcionario gerente, Produto produto) {
        String id = formataIdTime();
        times.add(new Time(gerente, produto, id));
    }

    public void addDesenvolvedorTime(Funcionario desenvolvedor, String idTime) {
        Time time = buscarTime(idTime);
        time.addDesenvolvedor(desenvolvedor);
    }
    
    public void removeDesenvolvedorTime(Funcionario desenvolvedor, String idTime) {
        Time time = buscarTime(idTime);
        time.removeDesenvolvedor(desenvolvedor);
    }
    
    public void addSprintTime(String idTime, String cpfLider, LocalDate inicio) {
        Funcionario lider = buscarFuncionario(cpfLider);
        Time time = buscarTime(idTime);

        time.addSprint(lider, inicio);
    }
    
    public void finalizaSprintTime(String idTime, String idSprint, LocalDate fim) {
        Time time = buscarTime(idTime);
        time.finalizaSprint(fim, idSprint);
    }
    
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Time> getTimes() {
        return times;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public String getCnpj() {
        return cnpj;
    }

    private String formataIdTime() {
        return "Time" + (this.times.size() + 1);
    }

    private Funcionario buscarFuncionario(String cpf) {
        for (Funcionario f : funcionarios)
            if (f.getCpf().equals(cpf))
                return f;

        throw new NullPointerException("Não existe");
    }

    private Time buscarTime(String id) {
        for (Time t : times)
            if (t.getId().equals(id))
                return t;

        throw new NullPointerException("Não existe");
    }

}
