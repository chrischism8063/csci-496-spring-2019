// Christopher Chism
// Templates and Operator Overloading Program
// Created: September 21, 2018
// Last Modified: October 8, 2018
// CSCI Course: 315
// Grade Received:  100
// Comments regarding design: Do not recall comments.

/* Array is templated, therefore only include the code if it is included from
 * the header file!
 */
#ifdef ARRAY_H
#include <stdio.h>
#include <iostream>

using namespace std;

/* Do a deep copy of the array into the list.
 * Note: This one uses a pointer!
 */
template <class T>
Array<T>::Array(const T *array, const int size)
{
  //Create deep copy of input array
  if(size > 0)
  {
    //Initialize member array
    mArray = new int[size];
    mSize = size;

    //Copies one for one from passed array to member array
    for(int i = 0; i < size; i++)
    {
        mArray[i] = array[i];
    }//END for loop
  }//END if loop

}//END array constructor with parameters array pointer and const int size

/* Do a deep copy of the array into the list
 * Note: This one uses a reference to a List!
 */
template <class T>
Array<T>::Array(const Array<T> &list)
{
  //Create deep copy of input array
  if(list != NULL)
  {
    //Initialize member array
    for(int a = 0; a < list.getLength(); a++)
    {
      //Deep copy 1 for 1 of the list objects array
      mArray[a] = list[a];
      //Copies the sizes over
      mSize = &list.getLength();
    }
  }//END if loop
}//END constructor with Array object passed

//Return the current length of the array
template <class T>
int Array<T>::getLength() const
{
  return this->mSize;
}

/*Returns the index in the array where value is found.
*Return -1 if value is not present in the array
*/
template <class T>
int Array<T>::indexOf(const T &value)
{
  for(int i = 0; i < this->getLength(); i++)
  {
    if(this->mArray[i] == value)
      return  i;
  }

  return -1;
}//END method indexOf

/*Removes an item at postion index by shiftfing later elemnets left.
*Returns tru iff - <= index < size
*/
template <class T>
bool Array<T>::remove(const int index)
{
	bool returnValue = false;
	//Checks for index to be in bounds
        if(index >= 0 && index < this->getLength())
        {
                for(int i = index; i < this->getLength(); i++)
                {
                  /*
                        if(i != this->getLength() - 1)
                        {
                          */
                                this->mArray[i] = this->mArray[i + 1];
                                returnValue = true;
                      //  }
                }
        }
	if(returnValue == true)
		this->mSize = this->getLength()-1;

	return returnValue;
}

//Used to print out the object as desired
template <class T>
void Array<T>::displayObject()
{
  cout << "Array Object{\n\tSize:\t" << this->getLength() << "\n\tArray{" << endl;

  for(int i = 0; i < this->getLength(); i++)
    cout << "\t\t" << this->mArray[i] << endl;

  cout << "\t}\n}" << endl;

}


//Used to print out the object as desired
//NEED HELP GETTING THIS TO FUNCTION PROPERLY
/*
template <class T>
ostream& Array<T>::operator<<(ostream &out, const Array<T> object)
{
  out << "Array Object{\n\tSize:\t" << object->getLength() << "\n\tArray{" << endl;

  for(int i = 0; i < object->getLength(); i++)
    out << "\t\t" << object->mArray[i] << endl;

  out << "\t}\n}" << endl;

  return out;
}

*/
// Retrieves the element at position pos
template <class T>
T& Array<T>::operator[](const int pos)
{
  return this->mArray[pos];
}


template <class T>
bool Array<T>::operator==(Array<T> &list) const
{
  bool returnValue = false;

  for(int i = 0; i < this->getLength(); i++)
  {
    if(this->mArray[i] != list.mArray[i])
    {
      return false;
    }
    else
      returnValue = true;
  }

  return returnValue;
}


template <class T>
Array<T>::~Array()
{
  //Checks for objects
  if(this->mArray || this->mSize)
  {
    delete[] mArray;
  }
}//END deconstructor

#endif
