class App extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      inputs: [
        {
          name : "Form1",
          disabled: () => { return false; },
          value: "" 
        },
        {
          name : "Form2",
          disabled: () => { return this.state.inputs[0].value === ""; },
          value: "" 
        },
        {
          name : "Form3",
          disabled: () => { return this.state.inputs[0].value === ""; },
          value: "" 
        }
      ]
    };
  }
  
  onInputChange = (e, index) => {
    const newInputs = this.state.inputs;
    newInputs[index].value = e.target.value;
    this.setState({ inputs: newInputs });
  };
  
  render() {
    return (
      <div>
        {this.state.inputs && 
            this.state.inputs.map((inputItem, index) => {
                return (
                  <div>
                    {this.state.inputs[index].name}:
                    <input onChange={(e) => { this.onInputChange(e, index); }} disabled={this.state.inputs[index].disabled()}/>
                  </div>
                );
            })}
      </div>
    );
  }
}

// Render it
ReactDOM.render(
  <App/>,
  document.getElementById("react")
);