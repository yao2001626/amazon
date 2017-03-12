all: duplicate rotate

duplicate: com_duplicate run_duplicate

com_duplicate:
	javac -d bin/ -cp src src/duplicate/Duplicate.java 

run_duplicate:
	for f in duplicate*.txt;                      \
	do                                            \
		echo "The content of $$f:";               \
		cat "$$f";                                \
		echo "Testing Duplicate on $$f:";         \
		java -cp bin duplicate/Duplicate < "$$f"; \
	done

rotate: com_rotate run_rotate

com_rotate:
	javac -d bin/ -cp src src/rotate/RotateArray.java 

run_rotate:
	for f in rotate*.txt;                        \
	do                                           \
		echo "The content of $$f:";              \
		cat "$$f";                               \
		echo "Testing RotateArray on $$f:";      \
		java -cp bin rotate/RotateArray < "$$f"; \
	done

clean:
	rm -rf bin/*
	rm *~