

import java.util.Objects;
import java.util.Random;
public class Processing {



    public boolean primo(int nv){  //Esta funcion comprueba si el numero que se le ingresa es primo.
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=nv)){
            if (nv % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }





    public int numeroAleatorio(){ //Esta funcion genera un numero aleatorio de el 1 al 100.
        Random random = new Random();
        return random.nextInt(100)+1;
    }


    public String nombreCientifico(){ //Esta funcion asigna el nombre del cientifico generando un numero aleatorio entre 1 y 2.
        Random random = new Random();
        int nv = random.nextInt(2)+1;
        if (nv == 1){
            return "Emmet Brown";
        }else{
            return "Marty Mcfly";
        }

    }

    public boolean coprimo (int a, int b){ //Esta funcion comprueba si el numero que se le ingresa es coprimo.
        int mcd ;
        int a1 = Math.max(a,b);
        int b1 = Math.min(a,b);
        do{
            mcd = b1;
            b1 = a1%b1;
            a1 = mcd;
        }while(b1!=0);
        return true;
    }

    //*


    public boolean crearHistoria(ListaEnlazada lista){ //Crea una lista historias.

        boolean creacion = false; //Si no se crea una historia devuelve false.


        if (lista.buscarUltimoNodo().evento == 'C' ) {  //Esta comparando si el ultimo elemento de la lista es un nodo C.

            int saltoTiempo = lista.buscarUltimoNodo().dato;

            if (coprimo(saltoTiempo, lista.buscarA().dato)) { //Compara si es comprimo con el evento A.


                if(primo(saltoTiempo) && Objects.equals(lista.buscarUltimoNodo().cientifico, "Emmet Brown")){ //Compara si es primo.

                    if(Objects.equals(lista.buscarA().cientifico, "Emmet Brown")) {
                        lista.historias.add("El viejo Emmet se dio a si mismo los planos del condensador de flujo");
                        int nv = numeroAleatorio();
                        lista.addElemento(nv, nombreCientifico(), 'A');


                    }else{
                        lista.historias.add("El viejo Emmet le dio a Marty Mcfly los planos del condensador de flujo");
                        int nv = numeroAleatorio();
                        lista.addElemento(nv, nombreCientifico(), 'A');


                    }
                    creacion = true;


                }else if (primo(saltoTiempo) && Objects.equals(lista.buscarUltimoNodo().cientifico, "Marty Mcfly")){ //Compara si es primo.

                    if(Objects.equals(lista.buscarA().cientifico, "Emmet Brown")) {
                        lista.historias.add("Marty le dio los planos a el viejo Emmet del condensador de flujo");
                        int nv = numeroAleatorio();
                        lista.addElemento(nv, nombreCientifico(), 'A');


                    }else{
                        lista.historias.add("Marty vio como mataban al doc y como viajaba en el tiempo");
                        int nv = numeroAleatorio();
                        lista.addElemento(nv, nombreCientifico(), 'A');


                    }
                    creacion = true;
                }else if(!primo(saltoTiempo)){
                    if(Objects.equals(lista.buscarUltimoNodo().cientifico, "Emmet Brown")){

                        lista.historias.add("El viejo emmet solo pudo observar");
                        int nv = numeroAleatorio();
                        lista.addElemento(nv, nombreCientifico(), 'A');
                        creacion = true;




                    }
                    else if(Objects.equals(lista.buscarUltimoNodo().cientifico, "Marty Mcfly")){
                        lista.historias.add("El marty solo pudo observar");
                        int nv = numeroAleatorio();
                        lista.addElemento(nv, nombreCientifico(), 'A');
                        creacion = true;




                    }
                }


            } else {
                lista.historias.add("Fin de la historia");


            }
        }
        else if (primo(lista.buscarUltimoNodo().dato)){ //Compara si es primo.

            if (lista.buscarUltimoNodo().evento == 'A') {  // si el ultimo evento es A crea un evento B.
                int ran = numeroAleatorio();
                lista.addElemento(ran, nombreCientifico(), 'B');
                creacion = true;

            } else if (lista.buscarUltimoNodo().evento == 'B') { // Si el ultimo evento es B crea un evento C.

                int ran = numeroAleatorio();
                lista.addElemento(ran, nombreCientifico(), 'C');
                creacion = true;

            }
        }else{
            lista.historias.add("fin de la historia");

        }
        return creacion;

    }




}








