package main

import (
	"bufio"
	"fmt"
	"math/rand/v2"
	"os"
	"strconv"
	"strings"
)

func main() {
	var rounds int = readInt("How many rounds do you wish to play?")
	gameLoop(rounds)
	fmt.Println("Game finished.")
}

func gameLoop(rounds int) {
	CHOICES := []string{"Rock", "Paper", "Scissors"}

	scoreUser, scoreCPU := 0, 0
	for round := 1; round <= rounds; round++ {
		fmt.Printf("\n========== Round %v =========\n", round)
		var userChoice int = getUserChoice()
		var cpuChoice int = getCPUInput()

		fmt.Printf("Cpu Chose %v\n", CHOICES[cpuChoice])
		// user wins
		if (userChoice == 1 && cpuChoice == 0) ||
			(userChoice == 2 && cpuChoice == 1) ||
			(userChoice == 0 && cpuChoice == 2) {
			fmt.Println("User wins!")
			scoreUser++
		} else if userChoice == cpuChoice {
			println("Draw!")
		} else {
			println("CPU Wins!")
			scoreCPU++
		}

		fmt.Printf("\nYour Score: %v\nCPU's Score: %v\n", scoreUser, scoreCPU)
	}

	var winner string
	if scoreCPU > scoreUser {
		winner = "CPU Wins"
	} else if scoreUser > scoreCPU {
		winner = "User Wins"
	} else {
		winner = "Tied Game"
	}
	println("====================")
	fmt.Printf("Game Over %v! \nYour Score: %v\nCPU's Score: %v\n", winner, scoreUser, scoreCPU)
	println("====================")

}

func userChoiceStrToInt(userChoice string) int {
	switch userChoice {
	case "rock":
		return 0
	case "paper":
		return 1
	case "scissors":
		return 2
	default:
		return -1
	}
}

func getUserChoice() int {
	var input string
	res := -1
	for res == -1 {
		input = readString("Rock Paper Or Scissors?")
		res = userChoiceStrToInt(strings.ToLower(input))
		if res == -1 {
			println("Invalid input, please type 'rock', 'paper', or 'scissors")
		}
	}
	return res
}

// gets user input from terminal via scanner (string)
func readString(message string) string {
	var scanner *bufio.Scanner = bufio.NewScanner(os.Stdin)
	println(message)
	scanner.Scan()
	line := scanner.Text()
	return line
}

// gets user input from terminal via scanner (int)
func readInt(message string) int {
	for {
		strInput := readString(message)
		val, err := strconv.Atoi(strInput)
		if err == nil && val > 0 {
			return val
		}
		fmt.Println("Please enter a valid number greater than zero.")
	}
}

func getCPUInput() int {
	var choice int = rand.IntN(3)
	return choice
}
