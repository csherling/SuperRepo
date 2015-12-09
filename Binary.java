/*
Christopher Sherling
APCS1 PD5
HW43 This or That
2015-12-07
 */

public class Binary {

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	_decNum = 0;
	_binNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_binNum = decToBinR(n);
	_decNum = n;
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_decNum = binToDecR(s);
	_binNum = s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum + " " + _decNum;
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
	String te = "";
	while(n != 0){
	    te = (n % 2) + te;
	    n /= 2;
	}
	return te;
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
	String te = "";
	if(n != 0){
	    te = decToBinR(n / 2) + (n % 2);
	}
	else{
	    return "";
	}
	return te;
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
        int te = 0;
	int ctr = 0;
	for(int i = s.length(); i > 0; i--){
	    te += Integer.parseInt(s.substring(i - 1, i)) * Math.pow(2, ctr);
	    ctr++;
	}
	return te;
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
	int te = 0;
	if(s.length() > 1){
	    te = binToDecR(s.substring(1, s.length())) + Integer.parseInt(s.substring(0, 1)) * (int)Math.pow(2, s.length() - 1);
	}
	else{
	    return ((int)Math.pow(2, 0) * (Integer.parseInt(s)));
	}//could return parseInt(s), but I chose this because it's a power of 2
	return te;
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/

    public boolean equals( Object other ) { 
	return ((this==other) || (this.tiString().equals(other.toString())));
    }
    /*
    */

    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/

    public int compareTo( Object other ) {
	if(this._decNum == ((Binary)other)._decNum){
	    return 0;
	}
	else if(this._decNum > ((Binary)other)._decNum){
	    return 1;
	}
	else{
	    return -1;
	}
    }
    /*
    */

    //main method for testing
    public static void main( String[] args ) {

	System.out.println(binToDec("0101")); //5
	System.out.println(binToDec("1010")); //10
	System.out.println(binToDecR("0101")); //5 
	System.out.println(binToDecR("1010")); //10
	System.out.println(decToBin(5)); //101
	System.out.println(decToBin(10)); //1010
	System.out.println(decToBinR(5)); //101
	System.out.println(decToBinR(10)); //1010


	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary("101");
	Binary b3 = b1;
	Binary b4 = new Binary(7);
	Binary b5 = new Binary(73);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       
	System.out.println( b5 );       

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
	/*=========================================
	  =========================================*/
    }//end main()

} //end class
