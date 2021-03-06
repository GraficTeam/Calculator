import java.util.Stack;

public class Evaluador_de_expresiones {

	//Verifica parentesis balanceados
	public String verifica1(String expresion) {
		Stack<Character> pila = new Stack<Character>();
		boolean error=false,error2=false;
		char fallo='a';
		String cadena;
        String mensaje = null;
        
        for(int iCont=0; iCont<expresion.length(); iCont++){

            if(expresion.charAt(iCont)=='{'){
            	pila.push((char)expresion.charAt(iCont));
            }
	        
	        else 
	        	if(expresion.charAt(iCont) == '}'){
	            if(!pila.empty()){ //Checa si la pila no est? vac?a
	                if(pila.peek().equals('{')){ //Si el elemento al tope de la pila concuerda con el caracter a entrar
	                    pila.pop();     //Saca el elemento del tope simbolizando que cierran bien
	                }else {
	                		error2=true;
	                		fallo=expresion.charAt(iCont);//Guarda el caracter de cerradura errado
	                }
	            }
	            else {
	            	//La pila esta vacia y el caracter es un carater de clausura
	            	mensaje="Error de llave que cierra se esperaba llave de apertura";
	            	//System.out.println("Error de llave que cierra se esperaba llave de apertura");
	                error=true;//Se activa la bandera de error para finalizar el programa
	            }
	        }
            if(expresion.charAt(iCont)=='['){
            	pila.push((char)expresion.charAt(iCont));
            }
            else if(expresion.charAt(iCont) == ']'){
                if(!pila.empty()){ //Checa si la pila no est? vac?a
                    if(pila.peek().equals('[')){ //Si el elemento al tope de la pila concuerda con el caracter a entrar
                        pila.pop();     //Saca el elemento del tope simbolizando que cierran bien
                    }else {
                    		error2=true;
                    		fallo=expresion.charAt(iCont);//Guarda el caracter de cerradura errado
                    }
                }
                else {
                	//La pila esta vacia y el caracter es un carater de clausura
                	mensaje="Error de corchete que cierra se esperaba corchete de apertura";
                	//System.out.println("Error de corchete que cierra se esperaba corchete de apertura");
                    error=true;//Se activa la bandera de error para finalizar el programa
                	 
                }
            }

            if(expresion.charAt(iCont)=='('){
            	pila.push((char)expresion.charAt(iCont));
            }
            else if(expresion.charAt(iCont) == ')'){
                if(!pila.empty()){ //Checa si la pila no est? vac?a
                    if(pila.peek().equals('(')){ //Si el elemento al tope de la pila concuerda con el caracter a entrar
                        pila.pop();  //Saca el elemento del tope simbolizando que cierran bien
                    }else {
                    		error2=true;
                    		fallo=(char)expresion.charAt(iCont);//Guarda el caracter de cerradura errado
                    }
                }
                else {
                	//La pila esta vacia y el caracter es un carater de clausura
                	mensaje="Error de parentesis que cierra se esperaba parentesis de apertura"; 
                	//System.out.println("Error de parentesis que cierra se esperaba parentesis de apertura");        
                    error=true;//Se activa la bandera de error para finalizar el programa
                }
            }
            
        
        }
      //La pila vacia simboliza que todos los caracteres cerraron, y no hubo error de que el primer caracter fuera uno de clausura
        if(pila.empty() && error==false && error2==false){ 
            //System.out.println("Todos los simbolos estan balanceados");
           
        }
        else{
        	
        	if(error==false && error2==false) {//El error no fue de que el primer caracter fuera uno de clausura
            	if(pila.peek().equals('{')) {
            		mensaje="Error de llave que abre falta llave que cierra";
            	}
            	if(pila.peek().equals('['))
            	{
            		mensaje="Error de corchete que abre falta corchete que cierra";
            	}
            	if(pila.peek().equals('(')) {
            		mensaje="Error de parentesis que abre falta parentesis que cierra";
            	}
        	}else {//error2 indica que el caracter de cerradura no concuerda con el de apertura
        		if(error==false) {
        		switch(pila.peek()) {
        			case '(':cadena=" se esperaba un parentesis de cerradura";
        					 break;
        			case '[':cadena=" se esperaba un corchete de cerradura";
					 			 break;
        			default:cadena=" se esperaba un llave de cerradura";
        		}
        		if(fallo=='}') {
        			mensaje="Error de llave que cierra"+cadena;
        		}
            	if(fallo==']')
            		mensaje="Error de corchete que cierra"+cadena;
            	if(fallo==')') {
            		mensaje="Error de parentesis que cierra"+cadena;
            	}
        	}
        	}
        	
        	
        }
        return mensaje;
    }

	//Verifica que las operaciones enten entre parentesis
	 public String verifica2(String expresion)
	    {
		 	String mensaje=null;
	    	int contadorSA=0;
	    	int contadorOP=0;
	    
	    	 for(int iCont=0; iCont<expresion.length(); iCont++){
	    		 if(expresion.charAt(iCont)=='('||expresion.charAt(iCont)=='{'||expresion.charAt(iCont)=='[')
	    			 contadorSA++;
	    			 if(expresion.charAt(iCont)=='+'||expresion.charAt(iCont)=='-'||expresion.charAt(iCont)=='*'||expresion.charAt(iCont)=='/'||expresion.charAt(iCont)=='^')
						contadorOP++;
	    	 }
	    	
	    	 if(contadorOP==contadorSA)

	    		 mensaje=null;
	    	 else
	    		 if(contadorOP==0)
		    		 mensaje="No hay operador";
	    		 else
	    		 mensaje="Cada operacion debe estar encerrada con signos de agrupacion";
	    	 return mensaje;
	    }
	 
	 //Verifica que eseste bien escrita
	 public String verifica3(String expresion){
	        char carant=expresion.charAt(0);
	        String mensaje=null;
	        boolean error=false;
	        int i=0;
	        while(i<expresion.length()&&error==false){
	            if(Character.isDigit(expresion.charAt(i))||expresion.charAt(i)=='.'){
	                if(carant==')'||carant=='}'||carant==']'){
	                    mensaje="Error, no se puede poner un numero o un punto despues de un signo de agrupacion de cerradura (],),})\n";
	                    error=true;                    
	                }                                       
	                else{
	                    carant=expresion.charAt(i);
	                }
	            }
	            else 
	            	if(expresion.charAt(i)=='('||expresion.charAt(i)=='{'||expresion.charAt(i)=='['){
		                if(carant=='('||carant=='{'||carant=='['){
		                    carant=expresion.charAt(i);
		                }
		                else 
		                	if(carant=='+' || carant=='-' || carant=='*' || carant=='/' || carant=='^'){
		                		carant=expresion.charAt(i);
			                }
			                else{
			                	mensaje="Error, no se puede poner un signo de agrupacion de abertura ([,(,{) despues de un numero o un punto";
			                    error=true;                         
			                }                                    
	            	}
	            else 
	            	if(expresion.charAt(i)==')'||expresion.charAt(i)=='}'||expresion.charAt(i)==']'){
		                if(carant==')'||carant=='}'||carant==']'){
		                    carant=expresion.charAt(i);
		                }
		                else 
		                	if(Character.isDigit(carant)){
		                    carant=expresion.charAt(i);
		                }
	                else{
	                	mensaje="Error, no se puede poner un signo de agrupacion de cerradura (],),}) despues de un '"+carant+"'";
	                    error=true;
	                }                                   
	            }
	            else if(expresion.charAt(i)=='+' ||expresion.charAt(i) =='-' || expresion.charAt(i)=='*' || expresion.charAt(i)=='/' || expresion.charAt(i)=='^'){
	                if(carant==')'||carant=='}'||carant==']'){
	                    carant=expresion.charAt(i);
	                }
	                else if(Character.isDigit(carant)){
	                    carant=expresion.charAt(i);
	                }
	                else{
	                    mensaje="Error, no se puede poner un operador ('"+expresion.charAt(i)+"') depues de un '"+carant+"'";
	                    error=true;                   
	                }                                       
	            }
	           i++;
	        }
	        return mensaje;
	    }
	 
	 //Verifica que los decimales enten bien escritos
	 public String verifica4(String expresion) {
			Stack<Character> pila = new Stack<Character>();
			
			boolean error=false;
	        int i=0;
	        int iCont=0;
	        
	        String mensaje=null;
	        while(iCont<expresion.length()&&error==false) {
	        	if(expresion.charAt(iCont)=='.') {
	        		i=iCont+1;
	        		while(error!=true&&expresion.charAt(i)!='+'&&expresion.charAt(i)!='-'&&expresion.charAt(i)!='*'&&expresion.charAt(i)!='/'&&expresion.charAt(i)!='^'&&expresion.charAt(i)!=')'&&expresion.charAt(i)!=']'&&expresion.charAt(i)!='}'){

	        			if(expresion.charAt(i)=='.')
	        				error=true;
	        			i++;
	        		}
	        	}
	        	iCont++;
	        }
	        if(error==true)
	        	mensaje="Error, en el numero decimal";
	     return mensaje;
		} 
}