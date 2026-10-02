public class Funcionario {

    private String cpf;
    private String nome;
    private Papel papel;
    
    public Funcionario(String cpf, String nome, String funcao) {
        this.cpf = cpf;
        this.nome = nome;
        this.papel = designaPapel(funcao);
    }
    
    public void promoverAGerente() {
        papel = designaPapel("Gerente");
    }
    
    public void promoverAProductOwner() {
        papel = designaPapel("ProductOwner");
    }

    private Papel designaPapel(String funcao) {
        if ("Desenvolvedor".equals(funcao)) {
            return new Desenvolvedor();
        } else if ("Gerente".equals(funcao)) {
            return new Gerente();
        } else if ("ProductOwner".equals(funcao)) {
            return new ProductOwner();
        }
        throw new IllegalArgumentException("Função inválida: " + funcao);
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Papel getPapel() {
        return papel;
    }
    
    @Override
    public String toString() {
        return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", papel=" + papel.getResponsabilidade() + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

}