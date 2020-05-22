while(iterator.hasNext())
        {
            Order order = (Order)iterator.next();

            order.setId(this.id);
            order.setCreated(this.created);
            order.setSender(this.sender);
            order.setReceiver(this.receiver);
            order.setInput(this.input);
            order.setOutput(this.output);
            order.setState(this.state);
            orders2.add(order);
            em.persist(order);
        }