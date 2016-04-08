package modelo;

/**
 * Created by roger_000 on 29/02/2016.
 */
public class Carta {

    private Integer id_carta;
    private String nome;
    private String tipo;
    private Integer pila;
    private Integer ataque;
    private Integer defesa;
    private Integer imagem_carta;



    public Integer getId_carta() {
        return id_carta;
    }

    public void setId_carta(Integer id_carta) {
        this.id_carta = id_carta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPila() {
        return pila;
    }

    public void setPila(Integer pila) {
        this.pila = pila;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getImagem_carta() {
        return imagem_carta;
    }

    public void setImagem_carta(Integer imagem_carta) {
        this.imagem_carta = imagem_carta;
    }

}
