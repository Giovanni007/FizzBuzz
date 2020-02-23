import React, {useState,useEffect} from "react"
import "./FizzBuzzForm.css"

let start = 1;
let end = 1;
const API = 'http://localhost:8080/fizzBuzzString?';

function FizzBuzzForm(){
    const [fizzBuzzString, setFizzBuzzString] = useState("")
    const [fizzBuzzReport, setFizzBuzzReport] = useState("")

    useEffect(() => {
        fetchFizzBuzzString(setFizzBuzzString,setFizzBuzzReport);
    });

    const handleSubmit = (e) => {
        e.preventDefault();
        fetchFizzBuzzString(setFizzBuzzString,setFizzBuzzReport);
    }

    return(
        <form className="fizzBuzzForm" onSubmit={handleSubmit}>
            <h1>FizzBuzz</h1>
            <p>Insert a interval of integer</p>
            <label>Start:</label>
            <input 
                id="start"
                name="start" 
                type="number"
                min="1" 
                defaultValue="1" 
                onChange ={event => start = event.target.value}
                required
            />
           <label>End:</label>
            <input id="end"
                name="end"
                type="number"
                min="1" 
                defaultValue="1" 
                onChange ={event => end = event.target.value}
                required 
            />
            <input type="submit" value="Submit"/>
            <h2>FizzBuzz String:</h2>
            <p>{fizzBuzzString}</p>
            <h2>FizzBuzz Report:</h2>
            <p>{fizzBuzzReport}</p>

        </form>
    );
}

function fetchFizzBuzzString(setFizzBuzzString,setFizzBuzzReport){
    fetch(API + 'start=' + start + '&end=' + end)
    .then(res => {    
        // check for error response
        if (!res.ok) {
          throw new Error(res.statusText);;
        }
        const data = res.text();

        return data;
    }).then(
        (text) => {
            let data = text.split(/\n|\r/);
            console.debug(data)
            console.debug(text)
            setFizzBuzzString(data[0])
            setFizzBuzzReport(data[1])
    }).catch(console.log)
}

export default FizzBuzzForm;

