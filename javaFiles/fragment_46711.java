public void cmdSubtractPoint(int index, SkillTree tree) {

        boolean subtract = false;

        if (this.blueTree.get(index).getInvestedPoints() != 0) {
            // Only subtract a point if the skill isn't empty
            int temp01 = this.blueTree.get(0).getInvestedPoints() + tree.blueTree.get(1).getInvestedPoints();
            int temp23 = this.blueTree.get(2).getInvestedPoints() + tree.blueTree.get(3).getInvestedPoints();
            int temp45 = this.blueTree.get(4).getInvestedPoints() + tree.blueTree.get(5).getInvestedPoints();
            int temp6 = this.blueTree.get(6).getInvestedPoints();

            switch (index) {
            case 0:
            case 1:
                if (((temp01 ) < 6) && ((temp23 + temp45 + temp6) != 0)) {
                    this.showToast();
                } else if (((temp01 + temp23) < 11) && ((temp45 + temp6) != 0)) {
                    this.showToast();
                } else if (((temp01 + temp23 + temp45) < 16) && (temp6 != 0)) {
                    this.showToast();
                } else {
                    subtract = true;
                }
                break;
            case 2:
            case 3:
                if (((temp01 + temp23) < 11) && ((temp45 + temp6) != 0)) {
                    this.showToast();
                } else if (((temp01 + temp23 + temp45) < 16) && (temp6 != 0)) {
                    this.showToast();
                } else {
                    subtract = true;
                }
                break;
            case 4:
            case 5:
                if (((temp01 + temp23 + temp45) < 16) && (temp6 != 0)) {
                    this.showToast();
                } else {
                    subtract = true;
                }
                break;
            case 6:
                subtract = true;
                break;
            }

            if (subtract) {
                this.pointsInBlueTree -= 1;
                this.blueTree.get(index).subtractPoint();
            }

        }
    }