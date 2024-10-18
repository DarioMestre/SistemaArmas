// Interfaz Comparable
interface Comparable {
    int compareTo(Object o);
}

// Clase abstracta Arma
abstract class Arma {
    protected int cantMuniciones;
    protected double alcance;
    protected String marca;
    protected int calibre;
    protected String estado;

    public Arma(int cantMuniciones, double alcance, String marca, int calibre, String estado) {
        this.cantMuniciones = cantMuniciones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
    }

    // metodo para verificar si el arma esta en condiciones para operar
    public boolean enCondicion() {
        return estado.equals("EN USO") && calibre >= 9;
    }
}

// Clase Policia
class Policia {
    private String nombre;
    private String apellido;
    private int legajo;

    public Policia(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Policia{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo=" + legajo +
                '}';
    }
}

// Clase Corta
class Corta extends Arma {
    private boolean esAutomatica;

    public Corta(int cantMuniciones, double alcance, String marca, int calibre, String estado, boolean esAutomatica) {
        super(cantMuniciones, alcance, marca, calibre, estado);
        this.esAutomatica = esAutomatica;
    }

    // Metodo para verificar distancia mayor a 200m
    public boolean efectividadMts() {
        return alcance > 200;
    }

    @Override
    public String toString() {
        return "Corta{" +
                "cantMuniciones=" + cantMuniciones +
                ", alcance=" + alcance +
                ", marca='" + marca + '\'' +
                ", calibre=" + calibre +
                ", estado='" + estado + '\'' +
                ", esAutomatica=" + esAutomatica +
                '}';
    }
}

// Clase Larga
class Larga extends Arma implements Comparable {
    private String justifUso;
    private int nivelArma;
    private boolean tieneSello;

    public Larga(int cantMuniciones, double alcance, String marca, int calibre, String estado,
                 String justifUso, int nivelArma, boolean tieneSello) {
        super(cantMuniciones, alcance, marca, calibre, estado);
        this.justifUso = justifUso;
        this.nivelArma = nivelArma;
        this.tieneSello = tieneSello;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Larga) {
            Larga otraArma" " = (Larga) o;
            return Integer.compare(this.nivelArma, otraArma.nivelArma);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Larga{" +
                "cantMuniciones=" + cantMuniciones +
                ", alcance=" + alcance +
                ", marca='" + marca + '\'' +
                ", calibre=" + calibre +
                ", estado='" + estado + '\'' +
                ", justifUso='" + justifUso + '\'' +
                ", nivelArma=" + nivelArma +
                ", tieneSello=" + tieneSello +
                '}';
    }
}

// Clase principal para probar el sistema
public class SistemaArmas {
    public static void main(String[] args) {
        // Crear objetos de la clase Policia
        Policia policia1 = new Policia("Dario", "Mestre", 123292);
        Policia policia2 = new Policia("Analia", "Gonzalez", 15678);

        // Crear armas
        Corta armaCorta = new Corta(15, 250, "Glock", 9, "EN USO", true);
        Larga armaLarga1 = new Larga(30, 500, "Winchester", 12, "EN USO", "Defensa", 4, true);
        Larga armaLarga2 = new Larga(25, 600, "Remington", 10, "EN USO", "Caza", 5, false);

        // Verificar condiciones de uso
        System.out.println("Arma corta en condiciones: " + armaCorta.enCondicion());
        System.out.println("Arma larga 1 en condiciones: " + armaLarga1.enCondicion());
        System.out.println("Arma larga 2 en condiciones: " + armaLarga2.enCondicion());

        // Comparar armas largas
        System.out.println("Comparando armas largas: " + armaLarga1.compareTo(armaLarga2));

        // Efectividad del arma corta
        System.out.println("Arma corta efectiva a más de 200m: " + armaCorta.efectividadMts());

        // Mostrar información de policías y armas
        System.out.println(policia1);
        System.out.println(armaCorta);
        System.out.println(armaLarga1);
        System.out.println(armaLarga2);
    }
}
