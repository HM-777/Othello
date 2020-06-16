public class Othello {
	private int row = 8;	//オセロ盤の縦横マス数(2の倍数のみ)
	// String [] grids = new String [row * row]; //局面情報
	private int [][] grids = new int [row][row];
	
	private int turn; //手番
private int empty=0;
private int placeable=2;
private boolean placeableflag=false;
	// コンストラクタ
	public Othello(){
		turn = -1; //黒が先手
		for(int x=0;x<row;x++) {
		for(int y = 0 ; y < row ; y++){
			grids[y][x] = 0; //初めは石が置かれていない


		}}
		grids[3][3] = -1;
		grids[4][4] = -1;
		grids[3][4] = 1;
		grids[4][3] = 1;
	}

	// メソッド
	public String checkWinner(){	// 勝敗を判断
		return "black";
	}
	public int getTurn(){ // 手番情報を取得
		return turn;
	}
	public int[] [] getGrids(){ // 局面情報を取得
		return grids;
	}
	public void changeTurn(){ //　手番を変更
	turn*=-1;
	}
	public boolean isGameover(){	// 対局終了を判断
		return true;
	}
	
	public int getRow(){ //縦横のマス数を取得
		return row;
	}

	public void checkPlaceable() {
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<row;j++) {
			    turnLeftUp(i, j,false);
			    turnUp(i, j,false);
			    turnRightUp(i, j,false);
			    turnLeft(i, j,false);
			    turnRight(i, j,false);
			    turnLeftDown(i, j,false);
			    turnDown(i, j,false);
			    turnRightDown(i, j,false);
			    
			    if(placeableflag==true) {
			    	grids[i][j]=placeable;
			    	placeableflag=false;
			    }
			}
		}
	}
 public void setStone(int x, int y) {

   

    // 駒を配置できる場合
    if (grids[y][x]==placeable) {
      grids[y][x] = turn;

      // ひっくり返す処理
      turnStone(x, y);

      changeTurn();
    } 

  }

   public void turnStone(int x, int y) {

    // 8方向の駒の配置を確認し、ひっくり返す

    turnLeftUp(x, y,true);
    turnUp(x, y,true);
    turnRightUp(x, y,true);
    turnLeft(x, y,true);
    turnRight(x, y,true);
    turnLeftDown(x, y,true);
    turnDown(x, y,true);
    turnRightDown(x, y,true);

  }

   
   //flagは盤面に操作を反映する場合にはtrueしない場合はfalse
  public void turnLeftUp(int x, int y,boolean flag) {
    if (y > 1 && x > 1) {

      // となりの駒
      int next = grids[y - 1][x - 1];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x - i < 0 || y - i < 0 || grids[y - i][x - i]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y - i][x - i]==turn) {
            // 自駒の場合
if(flag==false&&placeableflag==false) {placeableflag=true;}
            // あいだの駒をすべて自駒にひっくりかえす
 if(flag==true) {           for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y - t][x - t] = turn;
            }
            break;
          }}
        }
      }

    }
  }

   public void turnUp(int x, int y,boolean flag) {
    if (y > 1) {

      // となりの駒
      int next = grids[y - 1][x];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (y - i < 0 || grids[y - i][x]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y - i][x]==turn) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y - t][x] = turn;
            }
            break;
          }
        }
      }

    }
  }

   public void turnRightUp(int x, int y,boolean flag) {
    if (y > 1 && x < 6) {

      // となりの駒
      int next = grids[y - 1][x + 1];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x + i > 7 || y - i < 0 || grids[y - i][x + i]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y - i][x + i]==turn) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y - t][x + t] =turn;
            }
            break;
          }
        }
      }

    }
  }

   public void turnDown(int x, int y,boolean flag) {
    if (y < 6) {

      // となりの駒
      int next = grids[y + 1][x];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (y + i > 7 ||grids[y + i][x]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y + i][x]==turn) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y + t][x] = turn;
            }
            break;
          }
        }
      }

    }
  }

  public void turnRight(int x, int y,boolean flag) {
    if (x < 6) {

      // となりの駒
      int next = grids[y][x + 1];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x + i > 7 || grids[y][x + i]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y][x + i]==turn) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y][x + t] = turn;
            }
            break;
          }
        }
      }

    }
  }

   public void turnLeftDown(int x, int y,boolean flag) {
    if (y < 6 && x > 1) {

      // となりの駒
      int next = grids[y + 1][x - 1];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x - i < 0 || y + i > 7 || grids[y + i][x - i]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y + i][x - i]==turn) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y + t][x - t] = turn;
            }
            break;
          }
        }
      }

    }
  }

   public void turnLeft(int x, int y,boolean flag) {
    if (x > 1) {

      // となりの駒
      int next =grids[y][x - 1];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x - i < 0 || grids[y][x - i]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y][x - i]==turn) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y][x - t] = turn;
            }
            break;
          }
        }
      }

    }
  }

   public void turnRightDown(int x, int y,boolean flag) {
    if (y < 6 && x < 6) {

      // となりの駒
     int  next = grids[y + 1][x + 1];

      // となりの駒が裏駒の場合
      if (next==turn*-1) {

        // さらにその一つとなりから順に確認
        for (int i = 2; true; i++) {

          if (x + i > 7 || y + i > 7 || grids[y + i][x + i]==empty) {
            // 駒がない場合終了
            break;
          } else if (grids[y + i][x + i]==turn) {
            // 自駒の場合

            // あいだの駒をすべて自駒にひっくりかえす
            for (int t = 1; t < i; t++) {
              // 配列の要素を上書き
              grids[y + t][x + t] = turn;
            }
            break;
          }
        }
      }

    }
  }

}
