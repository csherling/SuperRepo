/*****************************
 * CODE for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/
/*  Team Red Squad  - Aleksandar Shipetich, Christopher Sherling
    APCS1 pd5
    HW42 -- Array of Titanium
    2015-12-05
*/
public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) { 
	Comparable temp;
	temp = _data[index];
	if(index <= _lastPos){
	    _data[index] = newVal;
	    return temp;
	}
	else{
	    return temp;
	}
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) { 
	if(_size == _data.length){
	    expand();
	    _data[_size] = newVal;
	    _lastPos++;
	    _size++;
	}
	else{
	    _data[_size] = newVal;
	    _lastPos++;
	    _size++;
	}

    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) { 
	if(index <= _size){//The if of chris's stupidity ~Chris. Checks if the insertion index is after lastpos. If it is, it shouldn't work
	    if(_size == _data.length){
		expand();
	    }
	    for(int i = _lastPos; i >= index; i--){
		_data[i + 1] = _data[i];
	    }
	    _lastPos++;
	    _size++;
	    _data[index] = newVal;
	}
    }

    // a, b, c, d, f
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
    	for (int i = index + 1; i < this._size; i++) {
	    this._data[i-1] = this._data[i];
    	}
	this._lastPos--;
    	this._size--;
    }


    //return number of meaningful items in _data
    public int size() { 
    	return this._size;
    }

    public int linSearch(Comparable co) {
	for(int i = 0; i < _size; i++){
	    if(_data[i].compareTo(co) == 0){
		return i;
	    }
	}
	return -1;
    }

    public boolean isSorted(){
	for(int i = 0; i < _lastPos; i++){
	    if(!(_data[i].compareTo(_data[i + 1]) == -1)){
		return false;
	    }
	}
	return true;
    }

    //main method for testing
    public static void main( String[] args ) {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	Comparable z1 = new Binary(15);
	Comparable z2 = new Binary(31);
	Comparable z3 = new Binary("1111");
	Comparable z4 = new Rational(45, 3);
	Comparable z5 = new Rational(62, 2);
	Comparable z6 = new Rational(15, 1);
	Comparable z7 = new Hexadecimal(15);
	Comparable z8 = new Hexadecimal(31);
	Comparable z9 = new Hexadecimal("F");
	Comparable z10 = new Hexadecimal(5);
	curtis.add(z1);
	curtis.add(z2);
	curtis.add(z3);
	curtis.add(z4);
	curtis.add(z5);
	curtis.add(z6);
	curtis.add(z7);
	curtis.add(z8);
	curtis.add(z9);
	curtis.add(z10);

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);


	System.out.println("Test compareTo()");
	System.out.println(z1.compareTo(z2));//-1
	System.out.println(z1.compareTo(z3));//0
	System.out.println(z1.compareTo(z4));//0
	System.out.println(z1.compareTo(z5));//-1
	System.out.println(z1.compareTo(z6));//0
	System.out.println(z1.compareTo(z7));//0
	System.out.println(z1.compareTo(z8));//-1
	System.out.println(z1.compareTo(z9));//0
	System.out.println(z1.compareTo(z10));//1
	System.out.println("z4");
	System.out.println(z4.compareTo(z2));//-1
	System.out.println(z4.compareTo(z3));//0
	System.out.println(z4.compareTo(z4));//0
	System.out.println(z4.compareTo(z5));//-1
	System.out.println(z4.compareTo(z6));//0
	System.out.println(z4.compareTo(z7));//0
	System.out.println(z4.compareTo(z8));//-1
	System.out.println(z4.compareTo(z9));//0
	System.out.println(z4.compareTo(z10));//1
	System.out.println("z7");
	System.out.println(z7.compareTo(z2));//-1
	System.out.println(z7.compareTo(z3));//0
	System.out.println(z7.compareTo(z4));//0
	System.out.println(z7.compareTo(z5));//-1
	System.out.println(z7.compareTo(z6));//0
	System.out.println(z7.compareTo(z7));//0
	System.out.println(z7.compareTo(z8));//-1
	System.out.println(z7.compareTo(z9));//0
	System.out.println(z7.compareTo(z10));//1
	System.out.println("z10");
	System.out.println(z10.compareTo(z2));//-1
	System.out.println(z10.compareTo(z3));//-1
	System.out.println(z10.compareTo(z4));//-1
	System.out.println(z10.compareTo(z5));//-1
	System.out.println(z10.compareTo(z6));//-1
	System.out.println(z10.compareTo(z7));//-1
	System.out.println(z10.compareTo(z8));//-1
	System.out.println(z10.compareTo(z9));//-1
	System.out.println(z10.compareTo(z10));//1

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	Comparable y1 = new Binary(1);
	Comparable y2 = new Binary(2);
	Comparable y3 = new Binary(3);
	Comparable y4 = new Rational(4, 1);
	Comparable y5 = new Rational(15, 3);
	Comparable y6 = new Rational(12, 2);
	Comparable y7 = new Hexadecimal(7);
	Comparable y8 = new Hexadecimal(8);
	Comparable y9 = new Hexadecimal(9);
	Comparable y10 = new Hexadecimal(10);
	mayfield.add(y1);
	mayfield.add(y2);
	mayfield.add(y3);
	mayfield.add(y4);
	mayfield.add(y5);
	mayfield.add(y6);
	mayfield.add(y7);
	mayfield.add(y8);
	mayfield.add(y9);
	mayfield.add(y10);
	
	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	System.out.println("linsearch");
	System.out.println(mayfield.linSearch(y5));//4
	System.out.println(mayfield.linSearch(z2));//-1
	System.out.println("isSorted");
	System.out.println(curtis.isSorted());//false
	System.out.println(mayfield.isSorted());//true
	
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,z2);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,z2);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,z2);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	
    }//end main
    
}//end class