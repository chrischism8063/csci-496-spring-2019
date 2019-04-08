// Christopher Chism
// Templates and Operator Overloading Program
// Created: September 21, 2018
// Last Modified: October 8, 2018
// CSCI Course: 315
// Grade Received:  100
// Comments regarding design: Do not recall comments.

#include <stdlib.h>
#include <iostream>
#include "array.hpp"

using namespace std;

int main(int argc, char *argv[])
{
    /* You may write manual tests here. */
    const int SIZE = 6;
    int array1[SIZE] = {510, 511, 512, 513, 514, 515};
    Array<int> myArrayObj(array1, SIZE);

    //Tested getLength
    cout << "********************Length of myArrayObj is " << myArrayObj.getLength() << endl << endl;
    myArrayObj.displayObject();

    //Tested indexOf
    cout << "********************Requesting index of 514 which is index 4:\t" << myArrayObj.indexOf(514) << endl << endl;
    myArrayObj.displayObject();
    //Tested remove
    cout << "********************Removing item 513 of index 3. Should return a bool of true/1:\t" << myArrayObj.remove(3) << endl << endl;
    myArrayObj.displayObject();
    //Tested overload operator of []
    cout << "********************Value at index 2 s/b 512:\t" << myArrayObj[2] << endl;
    myArrayObj.displayObject();

    int array2[SIZE] = {510, 511, 512, 513, 514, 515};
    Array<int> testArrayObj(array2, SIZE);

    cout << "Initial testArrayObj:::" << endl;
    testArrayObj.displayObject();

    cout << "Removing index 3 which is 513" << testArrayObj.remove(3);
  
  	cout << "Printing testArrayObject::::::::" << endl;  
    testArrayObj.displayObject();
    const bool myBool = (myArrayObj == testArrayObj);
    
    
    //Tested overload operator ==
    cout << "********************Checking to see if myArrayObj and testArrayObj are similiar:\t" << myBool << endl;
  myArrayObj.displayObject();
  cout << "AND" << endl;
  testArrayObj.displayObject();

}
