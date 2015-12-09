//Team - Sweet hexa-teen -- Bayle Smith-Salzberg and Jason Mohabir
//APCS1 pd10
//HW44 -- This or That or Fourteen Other Things
//2015-12-08

public class Hexadecimal {

    public int _decNum;
    public String _binNum;
    private final static String HEXDIGITS = "0123456789ABCDEF"; 

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_binNum = "0";

    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_binNum = decToBin(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_binNum = s;
	_decNum = binToDec(s);
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	String retStr = "";
	while (n > 0){
	    int remainder = n % 2;
	    n /= 2;
	    retStr += remainder;
	}
	return retStr;
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
	if (n < 2)
	    {return n+"";}
	return decToBinR(n/2)+ n%2 + "";

    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {

	int ret = 0;
        for (int i = 0; i < s.length(); i++){
	    ret += Integer.parseInt(s.substring(i, i+1))* Math.pow(2, i);
	}
	return ret;	    
	    
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) { 
	if (Integer.parseInt(s) < 10)
	    {return Integer.parseInt(s);}
	else {
	    int len = s.length();
	    return Integer.parseInt(s.substring(len)) + 
		2 * binToDecR(s.substring(0,len));
		}
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	//Check for alias                                                                                                                          
	boolean retval = this == other;
   /*    if ( ! (other instanceof Hexadecimal))
        	throw new ClassCastException("
        	\nMy first error message! "
        	+ " compareTo() input not a Hexadecimal") */
        if (!retval)
	    //Check for same class and then see if difference is 0 -> Equality                                                                                                   
	    retval = other instanceof Hexadecimal && this.compareTo((Hexadecimal)other) == 0;
        return retval;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if (((Hexadecimal)other)._decNum == this._decNum){
	    return 0;
	}
	else if (((Hexadecimal)other)._decNum > this._decNum){
	    return -1;
	}
	return 1;
    }


    //main method for testing
    public static void main( String[] args ) {

	  System.out.println();
	  System.out.println( "Testing ..." );

	  Hexadecimal b1 = new Hexadecimal(5);
	  Hexadecimal b2 = new Hexadecimal(5);
	  Hexadecimal b3 = b1;
	  Hexadecimal b4 = new Hexadecimal(7);

	  System.out.println( b1 );
	  System.out.println( b2 );
	  System.out.println( b3 );       
	  System.out.println( b4 );       

	  System.out.println( "\n==..." );
	  System.out.println( b1 == b2 ); //should be false
	  System.out.println( b1 == b3 ); //should be true

	  System.out.println( "\n.equals()..." );
	  System.out.println( b1.equals(b2) ); //should be true
	  System.out.println( b1.equals(b3) ); //should be true
	  System.out.println( b3.equals(b1) ); //should be true
	  System.out.println( b4.equals(b2) ); //should be false
	  System.out.println( b1.equals(b4) ); //should be false

	  System.out.println( "\n.compareTo..." );
	  System.out.println( b1.compareTo(b2) ); //should be 0
	  System.out.println( b1.compareTo(b3) ); //should be 0
	  System.out.println( b1.compareTo(b4) ); //should be neg
	  System.out.println( b4.compareTo(b1) ); //should be pos
	  System.out.println (decToBin(5) + "       expecting 101"); 
    }//end main()

} //end class
