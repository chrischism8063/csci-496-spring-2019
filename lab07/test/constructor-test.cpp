#include <cxxtest/TestSuite.h>
#include <limits.h>
#include <stdio.h>
#include "array.hpp"

class MyTestSuite1 : public CxxTest::TestSuite {
    public:
        void test1(void)
        {
          const int SIZE = 8;
          int *someArray = new int[SIZE]{312, 313, 314, 315, 316, 317, 318, 319};

          Array<int> array(someArray, SIZE);

          Array<int> otherArray(array);
            /* Fill in some test cases here for cxx test gen */
            TS_ASSERT(array==(otherArray));
        }
};
