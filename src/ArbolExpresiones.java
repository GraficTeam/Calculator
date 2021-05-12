import java.util.*;

class Nodo
{
    public String token;
    public Nodo hijoIzq, hijoDer;

    public Nodo()
    {
        token="";
        hijoIzq=null;
        hijoDer=null;
    }

    public Nodo(String token)
    {
        this.token=token;
        hijoIzq=null;
        hijoDer=null;
    }

    public Nodo(String token, Nodo hijoIzq, Nodo hijoDer)
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
    ArrayList<String> arreglo;
    Stack<Float> pilaInt;


    public ArbolExpresiones(String expresion)
    {
        this.expresion=expresion;
        raiz=null;
        pila=new Stack<Nodo>();
        arreglo=new ArrayList<String>();
        pilaInt=new Stack<Float>();
    }

    public ArbolExpresiones(String expresion, Nodo raiz)
    {
        this.expresion=expresion;
        this.raiz=raiz;
        pila=new Stack<Nodo>();
    }

    public void generaArbolExp()
    {
    	StringBuilder cadena=new StringBuilder();
        char caracter;
        Nodo nodoActual=null;

        for(int i=0;i<expresion.length();i++)
        {
            caracter=expresion.charAt(i);
            if (!Character.isDigit(caracter))
            {
            	if(caracter=='.') {
            		cadena.append(caracter);
            	}
            	else {
            		if(cadena.length()>0) {
                		Nodo n=new Nodo(cadena.toString());
                        if (nodoActual.hijoIzq==null)
                            nodoActual.hijoIzq=n;
                        else nodoActual.hijoDer=n;
                        cadena.delete(0, cadena.length());
                	}
                    if((caracter=='('||caracter=='{'||caracter=='['))
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
                        n.token=Character.toString(caracter);
                        nodoActual=n;
                    }
            	}
            }
            else {
            	cadena.append(caracter);
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

    public void enOrden(Nodo n)
    {
	   if (n!=null)
	    {
	     enOrden(n.hijoIzq);
	     arreglo.add(n.token);
	     enOrden(n.hijoDer);
	    }
	 }
    
    public void preOrden(Nodo n)
	  {
	   if (n!=null)
	    {
		 arreglo.add(n.token);
	     preOrden(n.hijoIzq);
	     preOrden(n.hijoDer);
	    }
	  }
    
    public void vaciarRe() {
    	arreglo.clear();
    }
    
    public String evaluaExp()
    {
        float aux=0;
        for(int i=0;i<arreglo.size();i++)
        {
            String car=arreglo.get(i);
            if (isNumeric(car))
            {
                pilaInt.push(Float.parseFloat(car));
            }
            else{
                float n1=pilaInt.pop();
                float n2=pilaInt.pop();
                switch(arreglo.get(i).charAt(0))
                {
                    case '*': aux=n1*n2;
                        break;
                    case '-':
                        if (n1 >0){
                            n1 = -n1;
                        }
                        aux = n1+n2;
                        break;
                    case '+': aux=n1+n2;
                        break;
                    case '/': aux=n2/n1;
                        break;
                    case '^':
                        double exponente;
                        exponente = Math.pow(n2,n1);
                        aux = (int)exponente;
                        break;

                }
                pilaInt.push(aux);

            }
        }
       return ""+pilaInt.pop();
    }

    public static boolean isNumeric(String cadena) {
    	boolean resultado;
    	try {
    		Float.parseFloat(cadena);
    		resultado=true;
    	}catch(NumberFormatException e) {
    		resultado = false;
    	}
    	return resultado;
    }
}
