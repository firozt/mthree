package main

import (
	"fmt"
	"strings"
)

func main() {
	// calls all questions
	Q1()
	Q2()
	Q3()
}

// ----------------------------------------------------------------------------------------//

// Q1
// Create a function called swap to swap the values of two integers using pointers
// Do not change the code in the main function

// Your code goes here
func swap(x *int, y *int) {
	*x, *y = *y, *x
}

func Q1() {
	x := 10
	y := 20

	swap(&x, &y)
	fmt.Println(x, y)
}

// ----------------------------------------------------------------------------------------//

// Q2
// Create a struct called Rectangle and a method called Area
// and the code that goes with it to calculate the area of the rectangle
// Be sure that the method Area is a method of Rectangle

// Your code goes here
type Rectangle struct {
	Width  uint
	Height uint
}

func (r Rectangle) Area() uint {
	return r.Height * r.Width
}

// Do not change the code in the main function
func Q2() {
	rect := Rectangle{Width: 10, Height: 5}
	fmt.Println("Area:", rect.Area())

}

// ----------------------------------------------------------------------------------------//

// Q3
// Write a function to count the words in the text that is passed to the function
func countWords(s string) map[string]int {
	wordList := strings.Split(s, " ")
	result := map[string]int{}
	for _, word := range wordList {
		result[word]++
	}
	return result
}

// Do not change the code in the main function
func Q3() {
	s := "go is fun and go is fast"
	fmt.Println(countWords(s))
	t := "this is a test this is only a test"
	fmt.Println(countWords(t))
}
