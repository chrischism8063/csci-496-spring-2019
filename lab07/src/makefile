
CC = g++

test: main.o array.o
	${CC} -o test main.o array.o

array.o: array.cpp array.hpp
	${CC} -c array.cpp array.hpp

main.o: main.cpp
	${CC} -c main.cpp

valgrind:
	valgrind ./test

clean:
	rm -rf array.o main.o
