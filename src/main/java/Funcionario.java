public class Funcionario {

    private String cpf;
    private String nome;
    private Papel papel;
    
    public Funcionario(String cpf, String nome, String funcao) {
        this.cpf = cpf;
        this.nome = nome;
        this.papel = designaPapel(funcao);
    }

    private Papel designaPapel(String funcao) {
        if (funcao.equals("Desenvolvedor")) {
            Papel teste = new Desenvolvedor("R$ 1.000", "Desenvolver");
            return teste;
        } else if (funcao.equals("Gerente")) {
            return new Gerente("R$ 2.000", "Gerenciar");
        } else if (funcao.equals("ProductOwner")) {
            return new ProductOwner("R$ 3.000", "Desenvolver");
        }
        throw new IllegalArgumentException("Função inválida: " + funcao);
    }

    public void promoverAGerente() {
        papel = new Gerente("R$ 5.000", "Gerenciar porra.");
    }

    public void promoverAProductOwner() {
        papel = new ProductOwner("R$ 8.000", "Gerenciar todos os produto.");
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
        return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", papel=" + papel + "]";
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