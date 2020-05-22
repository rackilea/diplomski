renderCharacters() {
        return this.state.characters.map(e => {
          return ("<tr><td>" + e.name + "</td></tr>")
        });
      }
    }