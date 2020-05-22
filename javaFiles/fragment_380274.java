db.test.find({
    $where: function () {
        for (var prop in this.b) {
            if (this.b[prop].c == 5) {
                return true;
            }
        }
        return false;
    }
})