import './App.css';

function App() {

  const [message, setMessage] = useState("");

  useEffect(() => {
    // fetch(url, options) : Http 요청 함수
    fetch("/nowij")
      .then(response => response.text())
      .then(message => {
        setMessage(message);
      });
  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <p>
          nowij : {message}
        </p>
      </header>
    </div>
  );
}

export default App;
