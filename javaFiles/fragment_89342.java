class CustomerList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            customers: []
        };
    }
    componentDidMount() {
        // fetch list data
        fetch('https://myapi.com/api/getCustomers', {userId: 12345, token: someToken})
            .then(res => res.json())
            .then(response => {
                this.setState({customers: response.customers});
            });
    }
    render() {
        const { customers } = this.state;
        return (
            <div className="customers">
                {customers.length && 
                    <ul>
                        {customers.map(customer => (
                            <li>
                                <div className="name">
                                    Name: {customer.name}
                                </div>
                                <div className="phone">
                                    Phone: {customer.phone || "Hidden"}
                                </div>
                            </li>
                        ))}
                    </ul>
                }
                {!customers.length && 
                    <div>Loading...</div>
                }
            </div>
        );
    }
}