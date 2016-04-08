package modelo;

/**
 * Created by Aluno on 01/04/2016.
 */
public class Historia {
    private Integer id_h;
    private String data;
    private String nome;
    private String desc;
    private Integer imagem;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    public Integer getId_h() {
        return id_h;
    }

    public void setId_h(Integer id_h) {
        this.id_h = id_h;
    }
}
