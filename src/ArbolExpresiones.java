import java.util.*;
import java.math.*;

class Nodo
{
    public char token;
    public Nodo hijoIzq, hijoDer;

    public Nodo()
    {
        token=' ';
        hijoIzq=null;
        hijoDer=null;
    }

    public Nodo(char token)
    {
        this.token=token;
        hijoIzq=null;
        hijoDer=null;
    }

    public Nodo(char token, Nodo hijoIzq, Nodo hijoDer)
    {
        this.token=token;
        this.hijoIzq=hijoIzq;
        this.hijoDer=hijoDer;
    }

    public String toString()
    {
        return " "+token+"\n";
    }
}

public class ArbolExpresiones
{
    String expresion;
    Nodo raiz;
    Stack<Nodo> pila;
    ArrayList<Character> arreglo;
    Stack<Integer> pilaInt;


    public ArbolExpresiones(String expresion)
    {
        this.expresion=expresion;
        raiz=null;
        pila=new Stack<Nodo>();
        arreglo=new ArrayList<Character>();
        pilaInt=new Stack<Integer>();
    }

    public ArbolExpresiones(String expresion, Nodo raiz)
    {
        this.expresion=expresion;
        this.raiz=raiz;
        pila=new Stack<Nodo>();
    }

    public void generaArbolExp()
    {
        char caracter;
        Nodo nodoActual=null;

        for(int i=0;i<expresion.length();i++)
        {
            caracter=expresion.charAt(i);

            if (!Character.isDigit(caracter))
            {
                if((caracter=='(')||(caracter=='{'))
                {
                    if(i==0)
                    {
                        raiz=new Nodo();
                        nodoActual=raiz;
                        pila.push(nodoActual);
                    }
                    else{
                        Nodo n=new Nodo();
                        if (nodoActual.hijoIzq==null)
                            nodoActual.hijoIzq=n;
                        else nodoActual.hijoDer=n;
                        nodoActual=n;
                        pila.push(nodoActual);
                    }
                }

                if((caracter=='*')||(caracter=='+')||(caracter=='-')||(caracter=='/')||(caracter=='^'))
                {
                    Nodo n=pila.pop();
                    n.token=caracter;
                    nodoActual=n;
                }
            }
            else {
                Nodo n=new Nodo(caracter);
                if (nodoActual.hijoIzq==null)
                    nodoActual.hijoIzq=n;
                else nodoActual.hijoDer=n;
            }
        }
    }


    public void PosOrden(Nodo n)
    {
        if(n!=null)
        {
            PosOrden(n.hijoIzq);
            //System.out.print(" "+n.token);
            PosOrden(n.hijoDer);
            arreglo.add(n.token);
        }
    }


    public void evaluaExp()
    {
        int aux=0;
        System.out.print(arreglo);
        for(int i=0;i<arreglo.size();i++)
        {
            Character car=arreglo.get(i);
            if (Character.isDigit(car))
            {
                pilaInt.push(Character.getNumericValue(car));
            }
            else{
                int n1=pilaInt.pop();
                int n2=pilaInt.pop();
                switch(arreglo.get(i))
                {
                    case '*': aux=n1*n2;
                        break;
                    case '-':
                        if (n2 >0){
                            n2 = -n2;
                        }
                        aux = n1+n2;
                        break;
                    case '+': aux=n1+n2;
                        break;
                    case '/': aux=n2/n1;
                        break;
                    case '^':
                        double exponente;
                        exponente = Math.pow(n1,n2);
                        aux = (int)exponente;


                }
                pilaInt.push(aux);

            }
        }
        System.out.println("\n"+pilaInt.pop());
    }


    public static void main(String args[])
    {

        String exp="{(4+5)*{(8/2)-2}}";

        ArbolExpresiones a=new ArbolExpresiones(exp);
        a.generaArbolExp();
        a.PosOrden(a.raiz);
        a.evaluaExp();
    }
}
