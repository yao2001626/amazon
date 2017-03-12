package main

import "fmt"
import "bufio"
import "strconv"
import "os"


func main() {
	inputfile := os.Args[1]
	f, err := os.Open(inputfile)
	if err != nil {
		  panic(err)
	}
	defer f.Close()
	
	
	fmt.Println("reading files", inputfile)
	data :=[] int64{}
	var tmp int64
	scanner := bufio.NewScanner(f)
	scanner.Split(bufio.ScanWords)
	for scanner.Scan() {
		tmp,_= strconv.ParseInt(string(scanner.Text()), 10, 32)
		data=append(data,tmp)
	}
	if err := scanner.Err(); err != nil {
		fmt.Printf("Invalid input: %s", err)
	}
	//fmt.Println(data)
}
