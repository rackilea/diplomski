constructor(props) {
  super(props);
  this.state = {
    IdInterruptor: '',
    IdCuarto: '',
    Pin: '',
    Dimmer: '',
    Cuartos: undefined,
  }
}

componentDidMount() {
  let Cuartos;
  axios.get("http://localhost:5000/API/Cuartos")
    .then(response => {

       const  a=JSON.stringify(response.data);
        console.log(response.data);
        axx.au=response.data;
       const b=JSON.stringify(axx.au.idcuarto);
        console.log("aqui estas" )
       for (let i = 1; i < b.length; i=i+2) {
         Cuartos.push({idcuarto:parseInt((JSON.stringify(axx.au.idcuarto))[i])});
       }
       this.setState({ Cuartos });
    });

}