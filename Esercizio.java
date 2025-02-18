//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {
    // Il programma parte con una chiamata a main().

    static void Visualizza(int[] V, int N){
        System.out.print("[ ");
        for(int i = 0; i < N; i++){
            System.out.print(" " + (i+1) + "° Animale: " + V[i]);
        }
        System.out.print(" ]");
    }

    static int Inserisci(int[] V, int N, int ie){
        Random rand = new Random();
        int elemento;
        int N2;
        elemento = (rand.nextInt(7) + 3) * 10;
        N2= N + 1;
        for(int i = N ; i > ie; i--){
            V[i] = V[i-1];
        }
        V[ie] = elemento;
        
        return N2;
    }

    static int Rimuovi(int[] V, int N, int ie){
        int N2;
        N2 = N - 1;
        for(int i = ie; i < N2; i++){
            V[i] = V[i+1];
        }
        return N2;
    }

    static int RimuoviDuplicati(int[] V, int N){
        int i,j;
        i = 0;
        while(i < N - 1){
            j = i + 1;
            while (j < N) {
                if(V[i] == V[j]){
                    N = Rimuovi(V, N, j);
                }else{
                    j++;
                }
            }
            i++;
        }
        return N;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N, G = 0;
        
        do{
            System.out.print("Inserire quanti animali arriveranno al lago: ");
            N = in.nextInt();
            if(N <= 0){
                System.out.println("Inserire un valore valido");
            }
        }while(N <= 0);

        int[] animali = new int[N * 10];
        
        G = Inserisci(animali, G, 0);

        for(int i = 1; i < N; i++){
            G = Inserisci(animali, G, i);
            Visualizza(animali, G);
            if(animali[i] > animali[i-1]){
              G = Rimuovi(animali, G, i-1);
            }
        }

        G = RimuoviDuplicati(animali, G);  
        System.out.println("");
        Visualizza(animali, G);
        
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md